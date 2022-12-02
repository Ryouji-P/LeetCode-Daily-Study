

//Recursive solution
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        
        for (Node child : root.children) {
            preorder(child);
        }
        return result;
    }
}

//Iterative solution
class Solution {
    public List<Integer> preorderStack(Node root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Stack<Node> toVisit = new Stack<>();
        toVisit.push(root);
        
        while (!toVisit.isEmpty()) {
            Node visited = toVisit.pop();
            result.add(visited.val);
            
            for (int i = visited.children.size() - 1; i >= 0; i--) {
                toVisit.push(visited.children.get(i));
            }
        }
        return result;
    }
}
