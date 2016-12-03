import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import org.json.*;
/**
 * A drop-down list.
 * 
 * @author imacat <imacat@mail.imacat.idv.tw>
 * @version 2014/02/12
 */
public class DropDownList extends Actor {

    /** The font size. */
    public static final int FONT_SIZE = 20;

    /** The items of the drop-down list. */
    private List<DropDownListItem> listItems = new ArrayList<DropDownListItem>();

    /** The selected item. */
    private int selected = -1;

    /** Whether this drop-down list is expanded. */
    private boolean isExpanded = false;

    /**
     * Creates a new drop-down list.
     * 
     * @param items the text of the list items
     * @param defaultValue the default item
     */
    public DropDownList(JSONArray items, int defaultValue)throws Exception {
        List<GreenfootImage> images = new ArrayList<GreenfootImage>();

        // Creates the text images and finds their max height and max width.
        int maxWidth = 0;
        int maxHieght = 0;
        for (int i = 0; i < items.length(); i++) {
            JSONObject j = items.getJSONObject(i);
            GreenfootImage image = new GreenfootImage(j.get("name").toString(), FONT_SIZE, Color.BLACK, new Color(0, 0, 0, 0));
            if (maxWidth < image.getWidth()) {
                maxWidth = image.getWidth();
            }

            if(maxWidth < 100){
                maxWidth = 100;
            }

            if (maxHieght < image.getHeight()) {
                maxHieght = image.getHeight();
            }
            images.add(image);
        }

        // Creates the images of the list items based on their text images.
        for (int i = 0; i < images.size(); i++) {
            GreenfootImage newImage = new GreenfootImage(maxWidth + 10, maxHieght + 10);
            newImage.setColor(Color.WHITE);
            newImage.fill();
            newImage.drawImage(images.get(i), 5, 5);
            newImage.setColor(Color.BLACK);
            newImage.drawRect(0, 0, newImage.getWidth() - 1, newImage.getHeight() - 1);
            images.set(i, newImage);
        }

        // Creates the list items.
        listItems = new ArrayList<DropDownListItem>();
        for (int i = 0; i < images.size(); i++) {
            DropDownListItem item = new DropDownListItem(this, i, images.get(i));
            listItems.add(item);
        }

        // Sets the current value to the default item.
        setImage(images.get(defaultValue));
        selected = defaultValue;
        isExpanded = false;
    }

    /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        // Checks if we are to expand or collapse the drop-down list.
        checkExpand();
    }

    /**
     * Expands the dorp-down list.
     * 
     */
    public void expandList() {
        for (int i = 0; i < listItems.size(); i++) {
            getWorld().addObject(listItems.get(i), getX(), getY() + (i + 1) * getImage().getHeight());
        }
        isExpanded = true;
    }

    /**
     * Collapses the dorp-down list.
     * 
     */
    public void collapseList() {
        getWorld().removeObjects(listItems);
        isExpanded = false;
    }

    /**
     * Sets the currently-selected item of the list.
     * 
     * @param value the order of the currently-selected item.
     */
    public void setSelected(int value) {
        selected = value;
        setImage(listItems.get(value).getImage());
    }

    /**
     * Returns the currently selected item.
     * 
     * @return the order of the selected item
     */
    public int getSelected() {
        return selected;
    }

    /**
     * Checks if we are to expand the drop-down list.
     * 
     */
    private void checkExpand() {
        if (Greenfoot.mouseClicked(this)) {
            if (!isExpanded) {
                expandList();
            } else {
                collapseList();
            }
        }
    }
}