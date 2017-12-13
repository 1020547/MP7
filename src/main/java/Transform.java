
/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {

    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

/**
 * How much the colors need to be moved.
 */
    public static final int MOVE_BLUE = 16;
    /**
     * How much the colors need to be moved.
     */

    public static final int MOVE_GREEN = 8;
    /**
     * How much the colors need to be moved.
     */

    public static final int MOVE_ALPHA = 24;

    /**
     * How much the colors need to be moved.
     */

    public static final int MASK = 0xFF;

    public static final int WHITE = 0x00FFFFFF;

    public static final int BLACK = 0x0;

    /**
     * How much the colors need to be moved.
     */
    public static final int THREE = 3;


    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
        for (int x = 0; x < newImage.length; x++) {
            for (int y = 0; y < newImage[x].length; y++) {
                if (x < originalImage.length - amount) {
                newImage[x][y] = originalImage[x + amount][y];
                } else {
                    newImage[x][y] = FILL_VALUE;
                }
            }
        }

        return newImage;
    }

    /**
     * Shift right like above.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the right
     * @return the shifted image
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
        for (int x = 0; x < newImage.length; x++) {
            for (int y = 0; y < newImage[x].length; y++) {
                if (x >= amount) {
                newImage[x][y] = originalImage[x - amount][y];
                } else {
                    newImage[x][y] = FILL_VALUE;
                }
            }
        }

        return newImage;
    }

    /**
     * Shift up like above.
     *
     * @param originalImage the image to shift up
     * @param amount the amount to shift the image up
     * @return the shifted image
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < newImage.length; x++) {
            for (int y = 0; y < newImage[x].length; y++) {
               if(x <= 5 || x>=newImage.length-5|| y <= 5 || y >= newImage[0].length-5) { //the x ones don't work on every image
                   int[] temp = partColor(originalImage[x][y]);
                   temp[1] = BLACK;
                   temp[2]= BLACK;
                   temp[2 + 1] = BLACK;

                   newImage[x][y] = movedBack(temp);
               }
               else {
                   newImage[x][y] = originalImage[x][y];
               }
            }
        }

        return newImage;
    }

//    public void quote(Graphics g, final int[][] originalImage) {
//        g.drawString("Chinny is a good TA", originalImage.length/2,  originalImage[0].length/2);
//    }
    /**
     * Shift down like above.
     *
     * @param originalImage the image to shift down
     * @param amount the amount to shift the image down
     * @return the shifted image
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
//        g.drawString("Chinny is a good TA", originalImage.length/2,  originalImage[0].length/2);
//        for (int x = 0; x < newImage.length; x++) {
//            for (int y = 0; y < newImage[x].length; y++) {
//                if (y >= amount) {
//                newImage[x][y] = originalImage[x][y - amount];
//                } else {
//                    newImage[x][y] = FILL_VALUE;
//                }
//            }
//        }

        return newImage;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
//        int[][] newImage = new int[originalImage.length][originalImage[0].length];
//        return moreAlpha(newImage, amount - 2);
        return null;
    }
/**
 * shift in order to center.
 *
 */
    public static final double HALF = 0.5;
    /**
     * Rotate the image right like above.
     *
     * @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
        int snow;
        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[x].length; y++) {
                snow = (int) (Math.random() *10);
                if (snow < 1) {
                    int[] temp = partColor(originalImage[x][y]);
                    temp[1] = WHITE;
                    temp[2]= WHITE;
                    temp[2 + 1] = WHITE;
                    newImage[x][y] = movedBack(temp);
                }
                else {
                    newImage[x][y] = originalImage[x][y];
                }
            }
        }
        return newImage;

    }

    /**
     * Flip the image on the vertical axis across its center.
     *
     * * @param originalImage the image to flip vertical
     * @return the rotated image
     */
    public static int[][] flipVertical(final int[][] originalImage) {
        int[][] newArray = new int[originalImage.length][originalImage[0].length];

        for (int indexX = 0; indexX < originalImage.length; indexX++) {
            for (int indexY = 0; indexY < originalImage[0].length; indexY++) {
                int red = findRed(originalImage[indexX][indexY]);
                int blue = findBlue(originalImage[indexX][indexY]);
                int green = findGreen(originalImage[indexX][indexY]);
                int alpha = findAlpha(originalImage[indexX][indexY]);

                final int three = 3;
                final int twentyfour = 24;
                final int sixteen = 16;
                final int eight = 8;

                int average = (red + blue + green) / three;

                red = average;
                blue = average;
                green = average;

                newArray[indexX][indexY] = (alpha << twentyfour)
                        | (blue << sixteen) | (green << eight) | (red);

            }

        }
//        for (int indexY = 0; indexY < originalImage[0].length; indexY++) {
//            for (int indexX = 0; indexX < originalImage.length; indexX++) {
//
//            }
//        }
        return newArray;

    }

    /**
     * Flip the image on the horizontal axis across its center.
     *
     * * @param originalImage the image to flip horizontal
     * @return the rotated image
     */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        int[][] newArray = new int[originalImage.length][originalImage[0].length];
        for (int indexX = 0; indexX < originalImage.length; indexX++) {
            for (int indexY = 0; indexY < originalImage[0].length; indexY++) {
                int red = findRed(originalImage[indexX][indexY]);
                int blue = findBlue(originalImage[indexX][indexY]);
                int green = findGreen(originalImage[indexX][indexY]);
                int alpha = findAlpha(originalImage[indexX][indexY]);

                final int three = 3;
                final int twentyfour = 24;
                final int sixteen = 16;
                final int eight = 8;

                if (red > green && red > blue) {
                    newArray[indexX][indexY] = originalImage[indexX][indexY];
                } else {
                    int average = (red + blue + green) / three;
                    blue = average;
                    green = average;
                    red = average;
                }
                newArray[indexX][indexY] = (alpha << twentyfour)
                        | (blue << sixteen) | (green << eight) | (red);
            }

        }
        return newArray;

    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;




    /**
     *
     *  red = red & 0x0FF.
     *  blue = (blue << MOVE_BLUE) & 0x0FF;
     *  green = (green << MOVE_GREEN) & 0x0FF;
     *  alpha = (alpha << MOVE_ALPHA) & 0x0FF;
     *
     *  newImage = alpha | blue | green | red;
     *@param hex is for stuff
     *  @return array of colors
     */
    public static int[] partColor(final int hex) {
        int[] colors =
            {(hex >> MOVE_ALPHA) & MASK,
                    (hex >> MOVE_BLUE) & MASK,
                    (hex >> MOVE_GREEN) & MASK,
                    hex & MASK};

        return colors;
    }

    /**
     * all that work but moved back.
     *
     * @param colors the thing thing
     * @return all colors moved back
     */
     public static int movedBack(final int[] colors) {
         int temp = colors[0] << MOVE_ALPHA
                 |
                 (colors[1] << MOVE_BLUE) | (colors[2] << MOVE_GREEN)
                 |
                 (colors[THREE]);
         return temp;
     }
     /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return something
     *
     */


    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[x].length; y++) {
                int[] temp = partColor(originalImage[x][y]);
                temp[THREE] += amount;
                if (temp[THREE] > MASK) {
                    temp[THREE] = MASK;
                } else if (temp[THREE] < 0) {
                    temp[THREE] = 0;
                }

                newImage[x][y] = movedBack(temp);

            }
        }


        return newImage;

    }

    /**
     * Remove red from the image.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {

        return moreRed(originalImage, -amount);
    }


    /**
     * Add green to the image.
     *
     * @param originalImage the image to add green to
     * @param amount the amount of green to add
     * @return the recolored image
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

            for (int x = 0; x < originalImage.length; x++) {
                for (int y = 0; y < originalImage[x].length; y++) {
                    int[] temp = partColor(originalImage[x][y]);
                    temp[2] += amount;
                    if (temp[2] > MASK) {
                        temp[2] = MASK;
                    } else if (temp[2] < 0) {
                        temp[2] = 0;
                    }

                    newImage[x][y] = movedBack(temp);

                }
            }
        return newImage;
    }

    /**
     * Remove green from the image.
     *
     * @param originalImage the image to remove green to
     * @param amount the amount of green to remove
     * @return the recolored image
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        return moreGreen(originalImage, -amount);
    }


    /**
     * Add blue to the image.
     *
     * @param originalImage the image to add blue to
     * @param amount the amount of blue to add
     * @return the recolored image
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[x].length; y++) {
                int[] temp = partColor(originalImage[x][y]);
                temp[1] += amount;
                if (temp[1] > MASK) {
                    temp[1] = MASK;
                } else if (temp[1] < 0) {
                    temp[1] = 0;
                }

                newImage[x][y] = movedBack(temp);

            }
        }
        return newImage;
    }

    /**
     * Remove blue from the image.
     *
     * @param originalImage the image to remove blue to
     * @param amount the amount of blue to remove
     * @return the recolored image
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {

    return moreBlue(originalImage, -amount);
    }



    /**
     * Increase the image alpha channel.
     *
     * @param originalImage the image to increase transparency
     * @param amount the amount of green to remove
     * @return recolored image
     */
    public static int[][] moreAlpha(final int[][] originalImage,int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
        int section = originalImage[0].length;
        for(int i = 0; i < 100; i++) {
            for (int y = 0; y < section; y++) {
                for (int x = 0; x < originalImage.length; x++) {
                    int[] temp = partColor(originalImage[x][y]);
                    temp[0] += amount;
                    if (temp[0] > MASK) {
                        temp[0] = MASK;
                    } else if (temp[0] < 0) {
                        temp[0] = 0;
                    }

                    newImage[x][y] = movedBack(temp);

                }
            }
            section-=originalImage.length/50;
            amount-=7;
        }
        return newImage;
    }

    /**
     * Decrease the image alpha channel.
     *
     *
     * @param originalImage the image to remove green to
     * @param amount the amount of green to remove
     * @return recolored image
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        return moreAlpha(originalImage, -amount);
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
        return null;
    }
    public static int findRed(final int color) {
        final int fullColor = 0xFF;
        return (color & fullColor);
    }

    /**
     *adfs.
     * @param color afd
     * @return adfs
     */

    public static int findGreen(final int color) {
        final int fullColor = 0xFF;
        final int eight = 8;
        int newColor = color >> eight;
        return (fullColor & newColor);
    }

    /**
     *ajif.
     * @param color ijadf
     * @return jldaks
     */

    public static int findBlue(final int color) {
        final int fullColor = 0xFF;
        final int sixteen = 16;
        int newColor = color >> sixteen;
        return (fullColor & newColor);
    }

    /**
     *jaidfl.
     * @param color jaf
     * @return joaisd;f
     */

    public static int findAlpha(final int color) {
        final int fullColor = 0xFF;
        final int twentyfour = 24;
        int newColor = color >> twentyfour;
        return (fullColor & newColor);
    }


    /**
     * Expand in the vertical axis around the image center.
     *
     * @param originalImage the image to expand
     * @param amount the factor by which the image's height is increased
     * @return the expanded image
     */

    public static int[][] expandVertical(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                newImage[x][y] = FILL_VALUE;
            }
        }

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                double centery = ((originalImage[0].length - 1) / 2);
                double roundy = (Math.floor(((y + amount - 1) - centery) / amount));
                int sourcey = (int) (roundy + centery + 1 / 2);

                newImage[x][y] = originalImage[x][sourcey];
            }
        }
        return newImage;

    }

    /**
     * Shrink in the horizontal axis around the image center.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's width is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Expand in the horizontal axis around the image center.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                newImage[x][y] = FILL_VALUE;
            }
        }

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[0].length; y++) {
                double centerx = (originalImage.length - 1) / 2;
                double roundx = Math.floor((x + amount - 1 - centerx) / amount);
                int sourcex = (int) (roundx + centerx + 1 / 2);

                newImage[x][y] = originalImage[sourcex][y];
            }
        }

        return newImage;
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];

        for (int x = 0; x < originalImage.length; x++) {
            for (int y = 0; y < originalImage[x].length; y++) {
                int[] temp = partColor(originalImage[x][y]);
                if (temp[1] < temp[2] && temp[THREE] < temp[2]) {
                    newImage[x][y] = FILL_VALUE;
                } else {
                    newImage[x][y] = originalImage[x][y];
                }

            }
        }
    return newImage;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */

    public static int[][] mystery(final int[][] originalImage) {
        int[][] newImage = new int[originalImage.length][originalImage[0].length];
        for (int x = 0; x < newImage.length; x++) {
            for (int y = 0; y < newImage[x].length; y++) {
                newImage[x][y] = originalImage[x][y] * 2;

            }
        }

        return newImage;
    }
}
