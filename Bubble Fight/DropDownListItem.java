import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A drop-down list item.
 * 
 * @author imacat <imacat@mail.imacat.idv.tw>
 * @version 2014/02/12
 */
public class DropDownListItem extends Actor {
    
    /** The drop-down list. */
    private DropDownList parentList = null;
    
    /** The order of the item in the drop-down list. */
    private int itemOrder = -1;
    
    /**
     * Creates a new drop-down list item.
     * 
     * @param parent the parent drop-down list
     * @param order the order of the item in the drop-down list
     * @param text the text of the item, as an image
     */
    public DropDownListItem(DropDownList parent, int order, GreenfootImage text) {
        parentList = parent;
        itemOrder = order;
        setImage(text);
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        // Checks if this item is selected.
        checkSelected();
    }
    
    
    /**
     * Checks if this item is selected.
     * 
     */
    private void checkSelected() {
        if (Greenfoot.mouseClicked(this)) {
            parentList.setSelected(itemOrder);
            parentList.collapseList();
        }
    }
}