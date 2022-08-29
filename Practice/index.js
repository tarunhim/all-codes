console.log("tarun");
class Node{

    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
const print = (node) => {
    console.log(node.val);
    if(node.left !== null) print(node.left);
    if(node.right !== null) print(node.right);
}
let root = new Node(5);
root.left = new Node(1);
root.right = new Node(4);
root.right.left = new Node(3);
root.right.right = new Node(6);
print(root);


var isValidBST = function(root) {
    
    const solve = (root,max,min) => {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        
        return solve(root.left,root.val,min) && solve(root.right,max,root.val);
    }
    return (root,Number.MAX_VALUE,Number.MIN_VALUE);
    
};
console.log(isValidBST(root));