package com.liuxiangwin.test.ChainResponsiblity;

public abstract class AbstractEmailHandler implements IemailHandler {

    private volatile IemailHandler next;

    public final void setNext(IemailHandler handler) {
        this.next = handler;
    }

    public final void handleRequest(Email email) {
        if (this.accept(email)) {
            this.doHandle(email);
        }
        else {
            this.next.handleRequest(email);
        }
    }

    protected abstract boolean accept(Email email);

    protected abstract void doHandle(Email email);

}
