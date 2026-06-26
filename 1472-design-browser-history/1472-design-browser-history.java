class BrowserHistory {
    class Node{
        String url;
        Node next;
        Node pre;
        Node(String url){
            this.url = url;
        }
    }
    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.pre = current;

        current = node;
    }
    
    public String back(int steps) {
        while(current.pre != null && steps>0){
            current = current.pre;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(current.next != null && steps>0){
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */