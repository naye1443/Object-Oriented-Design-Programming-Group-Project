package NozamaGui.Screens;

import DataTypes.IItem;
import DataTypes.Item;
import Model.Cart;
import Model.NozamaSystem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class CartScreen extends JFrame
{

    private JPanel cartPanel;
    private JTree cartTree;
    private JTextArea textArea1;
    private JButton checkOutButton;
    private JLabel priceLabel;
    private JButton returnButton;
    private JCheckBox apply5CouponCheckBox;
    private JCheckBox apply10CouponCheckBox;
    private JButton deleteButton;
    private JSpinner spinner1;


    public CartScreen(Cart cart)
    {
        setTitle("Cart");
        setContentPane(cartPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTreeModel treeContents = setupTreeContents(cart);

        cartTree.setModel(treeContents);

        priceLabel.setText("Total: $" + String.format("%.02f", NozamaSystem.getInstance().getCart().calculateTotalFromCart()));

        cartTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e)
            {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) cartTree.getLastSelectedPathComponent();

                if (selectedNode.equals(cartTree.getModel().getRoot()))
                    return;

                if (selectedNode.getParent().equals(cartTree.getModel().getRoot()))
                {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) cartTree.getSelectionPath().getLastPathComponent();
                    textArea1.setText(String.valueOf(cart.getCart().get(selectedNode.getParent().getIndex(node))));
                }

            }
        });


        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckoutScreen screen = new CheckoutScreen(NozamaSystem.getInstance().getCart());
                CartScreen.this.dispose();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CustomerDashboard screen = new CustomerDashboard();
                CartScreen.this.dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) cartTree.getLastSelectedPathComponent();

                if (selectedNode == null)
                    return;

                if (selectedNode.equals(cartTree.getModel().getRoot()))
                    return;

                if (selectedNode.getParent().equals(cartTree.getModel().getRoot()))
                {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) cartTree.getSelectionPath().getLastPathComponent();
                    int index = selectedNode.getParent().getIndex(node);

                    NozamaSystem.getInstance().getCart().removeItem(cart.getCart().get(index),(int) spinner1.getValue());

                    CartScreen screen = new CartScreen(NozamaSystem.getInstance().getCart());
                    CartScreen.this.dispose();

                }

            }
        });


        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {

                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) cartTree.getLastSelectedPathComponent();


                if (selectedNode == null)
                {
                    spinner1.setValue(1);
                    return;
                }

                if (selectedNode.equals(cartTree.getModel().getRoot()))
                {
                    spinner1.setValue(1);
                    return;
                }

                if (selectedNode.getParent().equals(cartTree.getModel().getRoot()))
                {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) cartTree.getSelectionPath().getLastPathComponent();
                    int index = selectedNode.getParent().getIndex(node);

                    int quantity = cart.getQuantity(index);

                    if ((int) spinner1.getValue() > quantity)
                    {
                        spinner1.setValue(quantity);
                    }
                    else if ((int) spinner1.getValue() < 1)
                    {
                        spinner1.setValue(1);
                    }
                }


            }
        });



        NozamaSystem.getInstance().informView(CartScreen.this); //same thing as setVisible(true); // must be last line


    }

    public DefaultTreeModel setupTreeContents(Cart cart)
    {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Cart");

        int count = 0;

        for (IItem item : cart.getCart())
        {
            if (item.isBundle())
            {

            }
            else
            {
                Item i = (Item) item;
                DefaultMutableTreeNode temp = new DefaultMutableTreeNode(i.getName() + " (" + cart.getQuantity(count) + ")");
                rootNode.add(temp);
            }

            count += 1;

        }

//        DefaultMutableTreeNode A = new DefaultMutableTreeNode("A");
//        DefaultMutableTreeNode B = new DefaultMutableTreeNode("B");
//
//        DefaultMutableTreeNode A1 = new DefaultMutableTreeNode("A1");
//        DefaultMutableTreeNode A2 = new DefaultMutableTreeNode("A2");
//
//        DefaultMutableTreeNode B1 = new DefaultMutableTreeNode("B1");
//        DefaultMutableTreeNode B2 = new DefaultMutableTreeNode("B2");
//        DefaultMutableTreeNode B3 = new DefaultMutableTreeNode("B3");
//
//        rootNode.add(A);
//        rootNode.add(B);
//
//        A.add(A1);
//        A.add(A2);
//
//        B.add(B1);
//        B.add(B2);
//        B.add(B3);

        return new DefaultTreeModel(rootNode);
    }


}
