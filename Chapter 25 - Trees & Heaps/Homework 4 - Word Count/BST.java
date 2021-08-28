import java.util.ArrayList;

/**Class: BST
* @author Cynthia Johnson, edited by Jeremy Cooley
* @version 1.0
* Course : ITEC 3150
* Written: October 2, 2018
*
*
* This class � holds the fields, constructors, and methods to 
* create and traverse a binary tree
*/
public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;

	/**
	 * Create a default binary tree
	 */
	public BST() {	}

	/**
	 * Create a binary tree from an array of objects
	 */
	public BST(E[] objects)
	{
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	@SuppressWarnings("unchecked")
	public BST(ArrayList<WordCount> wordCountAL) 
	{
		for (int i = 0; i < wordCountAL.size(); i++)
			insert((E) wordCountAL.get(i));
	}

	///////////////////////////////////////////////////////////
	
	@Override
	/* Returns true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null)
		{
				if (e.compareTo(current.element) < 0)
				{
						current = current.left;
				}
				else if (e.compareTo(current.element) > 0)
				{
						current = current.right;
				}
				else // element matches current.element
				{
						return true; // Element is found
				}
		}

		return false;
	}

	@Override
	/* Method: insert()
	 *
	 * @param E e
	 * @return boolean
	 * 
	 * Insert element e into the binary tree. Return
	 * true if the element is inserted successfully,
	 * false if not/the element already exists.
	 */
	public boolean insert(E e) 
	{
		if (root == null)
			root = createNewNode(e); // Create a new root
		else
		{
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;

			// Search the tree
			while (current != null)
			{
					int compareVariable = e.compareTo(current.element);
					if (compareVariable < 0)
					{
							parent = current;
							current = current.left;
							// moves to the left
					}
					else if (compareVariable > 0)
					{
							parent = current;
							current = current.right;
							//moves to the right
					}
					else
					{
							// The compare() method of WordCount increments the count
							// if current is of type WordCount and the word matches.

							// The reason I put the increment in the compare method
							// is so that BST can be composed of other types of classes.
							return false;
							// Duplicate node not inserted
							// while loop & method broken out of

					}
			}


			// If it hasn't found a match, and the child/current
			// is null, i.e. DNE, then we can create the new node
			// and attach it to the parent node
			if (e.compareTo(parent.element) < 0)
			{
					parent.left = createNewNode(e);
			}
			else
			{
					parent.right = createNewNode(e);
			}
		}

		size++;
		return true; // Element inserted successfully
	}




	protected TreeNode<E> createNewNode(E e)
	{
		return new TreeNode<E>(e);
	}

	@Override
	/* Inorder traversal from the root */
	public void inorder()
	{
		inorder(root);
	}

	/* Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root)
	{
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.element + " ");
		inorder(root.right);
	}

	
	/** Method: reverseOrder()
	 * 
	 * Inorder traversal from the root
	 * No parameter or return needed because the string
	 * representations are printed to the console.  
	**/
	public void reverseOrder()
	{
		reverseOrder(root);
	}	
	
	/** Method: reverseOrder(root)
	 * 
	 * @param root
	 * 
	 * Inorder traversal from the root
	 * No parameter or return needed because the string
	 * representations are printed to the console.  
	 */
	protected void reverseOrder(TreeNode<E> root)
	{
		if (root == null)
			return;
		reverseOrder(root.right);
		System.out.println( root.element.toString() );
		reverseOrder(root.left);
	}

	@Override
	/* Postorder traversal from the root */
	public void postorder()
	{
		postorder(root);
	}

	/**
	 * Postorder traversal from a subtree
	 */
	protected void postorder(TreeNode<E> root)
	{
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.element + " ");
	}

	@Override
	/* Preorder traversal from the root */
	public void preorder()
	{
		preorder(root);
	}

	/**
	 * Preorder traversal from a subtree
	 */
	protected void preorder(TreeNode<E> root)
	{
		if (root == null)
			return;
		System.out.println(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/**
	 * This inner class is static, because it does not access any instance members
	 * defined in its outer class
	 */
	public static class TreeNode<E extends Comparable<E>>
	{
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) 
		{
			element = e;
		}
	}

	@Override
	/* Get the number of nodes in the tree */
	public int getSize()
	{
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot()
	{
		return root;
	}

	/**
	 * Returns a path from the root leading to the specified element
	 */
	public java.util.ArrayList<TreeNode<E>> path(E e)
	{
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array list of nodes
	}

	@Override
	/*
	  Delete an element from the binary tree. Return true if the element is deleted
	  successfully Return false if the element is not in the tree
	 */
	public boolean delete(E e)
	{
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null)
		{
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left child
		if (current.left == null)
		{
			// Connect the parent with the right child of the current node
			if (parent == null)
			{
				root = current.right;
			}
			else
			{
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		else
		{
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null)
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}

	/** Remove all elements from the tree */
	public void clear()
	{
			root = null;
			size = 0;
	}

	@Override
	/* Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator()
	{
		return new InorderIterator();
	}





	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> 
	{
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0; // Point to the current element in list

		public InorderIterator() 
		{
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() 
		{
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root)
		{
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override
		/* More elements for traversing? */
		public boolean hasNext()
		{
			return current < list.size();

		}

		@Override
		/* Get the current element and move to the next */
		public E next()
		{
			return list.get(current++);
		}

		@Override
		/* Remove the current element */
		public void remove()
		{
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}


}
