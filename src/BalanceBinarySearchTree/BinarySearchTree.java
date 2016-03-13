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
public class BinarySearchTree<T extends Comparable<?>> extends BinaryTree<T>{

    public BinarySearchTree(T value) {
        super(value, null, null);
    }
    
    public BinarySearchTree insertNode(T value){
        this.insertNode(new BinarySearchTree(value));
        return (BinarySearchTree)this.getRoot();
    }
    
    public void insertNode(BinaryTree node){
        node.parent = this;
        
        if(node.value.compareTo(this.value) < 0){
            if(this.getLeftChild() == null){
                this.setLeftChild(node);
            }
            else{
                ((BinarySearchTree)this.getLeftChild()).insertNode(node);
            }
        }else{
            if(this.getRightChild() == null){
                this.setRightChild(node);
            }
            else{
                ((BinarySearchTree)this.getRightChild()).insertNode(node);
            }
        }
    }
    
    public boolean removeNode(T value){
        /*if(this.value.compareTo(value) == 0){
            
            
            return true;
        }else{
            if(this.value.compareTo(value) < 0){
                if(this.getLeftChild() == null){
                    this.getLeftChild().
                }
            }else{
                if(this.getRightChild() == null){
                    this.setRightChild(node);
                }
            }
        }*/
        
        return false;
    }
    
    public static void main(String[] args){
        BinarySearchTree root = new BinarySearchTree<Integer>(new Integer(10));
        
        root.insertNode(5);
        root.insertNode(4);
        root.insertNode(15);
        root.insertNode(6);
        root.insertNode(20);
        root.insertNode(16);
        root.insertNode(1);
        
        
        
        root.print();
    }


    @Override
    public BinaryTree deleteNode(BinaryTree node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
