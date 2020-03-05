#include <iostream>
using namespace std;

struct Node
{
    int dataValue;
    struct Node* right, *left;
};

Node* addNewNode(int key)
{
	Node* node = new Node;
	node->dataValue = key;
	node->left = NULL;
    node->right = NULL;
	return node;
}

Node* insertNode(Node* temp, int key)
{
	if (temp == NULL)
		return addNewNode(key);

	if (key < temp->dataValue)
		temp->left = insertNode(temp->left, key);

    if (key > temp->dataValue)
		temp->right = insertNode(temp->right, key);

	return temp;
}

void printInOrder(struct Node* temp)
{
  cout << temp->dataValue<<" ";
}

void sortInOrder(struct Node* temp)
{
    if (temp == NULL)
        return;
    sortInOrder(temp->left);
    printInOrder(temp);
    sortInOrder(temp->right);
}

  int main()
{
  Node* rootNode = NULL;

	int values[] = { 100, 4, 52 , 99, 87, 1,7,22,55 };
    rootNode = insertNode (rootNode,100);
    rootNode = insertNode (rootNode,4);
    rootNode = insertNode (rootNode,30);
    rootNode = insertNode (rootNode,52);
    rootNode = insertNode (rootNode,99);
    rootNode = insertNode (rootNode,87);
    rootNode = insertNode (rootNode,1);
    rootNode = insertNode (rootNode,7);
    rootNode = insertNode (rootNode,22);
    rootNode = insertNode (rootNode,55);

  cout << "Sorted List is: "<< " ";
	sortInOrder(rootNode);

  return 0;
}
