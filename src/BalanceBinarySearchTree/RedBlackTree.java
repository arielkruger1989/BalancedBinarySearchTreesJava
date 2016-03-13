/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalanceBinarySearchTree;

/**
 *
 * @author ariel
 */
public class RedBlackTree<T extends Comparable<?>> extends BalancedBinaryTree{
    public boolean color = true; //true for red and false for black 

    public RedBlackTree(T value) {
        super(value);
    }

    @Override
    public boolean isBalanced() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
