package com.adolfoeloy.datastructure;

import java.util.function.Consumer;

public class CircularDoublyLinkedList {

    public static class QueueNode<T> {
        QueueNode prev;
        QueueNode next;
        T data;

        QueueNode(T data) {
            this.data = data;
            this.prev = this;
            this.next = this;
        }
    }

    <T> boolean isEmpty(QueueNode<T> qn) {
        return (qn.next == qn);
    }

    <T> void addTail(QueueNode<T> head, QueueNode<T> q) {
        q.next = head;
        q.prev = head.prev;
        head.prev.next = q;
        head.prev = q;
    }

    <T> void forEach(Consumer<QueueNode<T>> consumer, QueueNode<T> head) {
        QueueNode<T> q = head;
        while (true) {
            consumer.accept(q);
            q = q.next;
            if (q == head) {
                break;
            }
        }
    }

    <T> int size(QueueNode<T> q) {
        return _size(q, q);
    }

    private <T> int _size(QueueNode<T> q, QueueNode<T> h) {
        if (q.next != h) {
            return 1 + _size(q.next, h);
        }
        return 1;
    }
}
