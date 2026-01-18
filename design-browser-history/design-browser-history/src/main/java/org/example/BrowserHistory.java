package org.example;

class BrowserHistory {

    private String[] history = new String[5001];
    int currentIndex = 0;
    int size = 1;

    public BrowserHistory(String homepage) {
        history[currentIndex] = homepage;
        size = currentIndex + 1;
    }

    public void visit(String url) {
        history[++currentIndex] = url;
        size = currentIndex + 1;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history[currentIndex];
    }

    public String forward(int steps) {
        currentIndex = Math.min(size - 1, currentIndex + steps);
        return history[currentIndex];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
