package com.santiago.di03_aNote.controlador;

import com.santiago.di03_aNote.modelo.Page;
import javafx.scene.control.TreeItem;

import java.util.HashMap;

public class TreeViewPagesBinding {
    HashMap<TreeItem, Page> pagesBinding;

    public TreeViewPagesBinding() {
        this.pagesBinding = new HashMap<>();
    }

    public TreeViewPagesBinding(HashMap<TreeItem, Page> pagesBinding) {
        this.pagesBinding = pagesBinding;
    }

    public void bindBidirectional(TreeItem treeItem, Page page) {
        pagesBinding.put(treeItem, page);
        treeItem.valueProperty().bindBidirectional(page.title());
    }

    public void unbindBidirectional(TreeItem treeItem) {
        treeItem.valueProperty().unbindBidirectional(pagesBinding.get(treeItem).title());
        pagesBinding.remove(treeItem);
    }

    public Page getPage(TreeItem treeItem) {
        return pagesBinding.get(treeItem);
    }

    public TreeItem getTreeItem(Page page) {
        for (TreeItem treeItem : pagesBinding.keySet()) {
            if (pagesBinding.get(treeItem).equals(page)) {
                return treeItem;
            }
        }
        return null;
    }

    public void clear() {
        pagesBinding.clear();
    }

    public boolean isEmpty() {
        return pagesBinding.isEmpty();
    }

    public int size() {
        return pagesBinding.size();
    }

    public boolean containsKey(TreeItem treeItem) {
        return pagesBinding.containsKey(treeItem);
    }

    public boolean containsValue(Page page) {
        return pagesBinding.containsValue(page);
    }

    public Page remove(TreeItem treeItem) {
        return pagesBinding.remove(treeItem);
    }

}
