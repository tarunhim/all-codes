console.log("tarun");


var isValidBST = function(root) {
    
    const solve = (root,max,min) => {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        
        return solve(root.left,root.val,min) && solve(root.right,max,root.val);
    }
    return (root,Number.MAX_VALUE,Number.MIN_VALUE);
    
};