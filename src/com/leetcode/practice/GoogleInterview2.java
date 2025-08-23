package com.leetcode.practice;

public class GoogleInterview2 {
    /*
Assume that a CircularArray data structure is available for your use, an array-like data structure with fixed capacity.  It provides the following functions.

pushFront(E)/pushBack(E): Push the given element E to the front/back of the instance in O(1).
popFront()/popBack(): Remove the front/back element of the instance and return to the caller in O(1).
insert(index, E): Insert the given element E to the specified index.
set(index, E): Overwrite the element at the specified index with the given element E in O(1).
size()/capacity(): Fetch the current/maximum number of elements stored in the instance.
isFull(): Return true if the instance is full, false otherwise.
get(index): Fetch the value at the specified index in O(1).
*/
//    class CircularArray {
//
//    }
//
//    class CircularArraysDeque<TypeName> {
//        // Each element is a CircularArray of fixed capacity.
//        // All elements are filled to capacity except for the first and the last which may be non-full.
//        private List<CircularArray<T>> data;
//        // The capacity of each of the arrays within data.
//        private int circularArrayCapacity;
//        void insertArrayInLast() {
//            data.add(new CircularArray(this.circularArrayCapacity));
//        }
//
//        // Assume get/push/pop/size functions of a deque already implemented.
//        // O(size()/ circularArrayCapacity + circularArrayCapacity)
//        // Implement this function to provide indexed insertion.
//        void insert(int index, TypeName element) {
//            boolean ra = ifSpaceAvailableInRight();
//
//            if (!ra) {
//                insertArrayInLast();
//            }
//
//            int sizeFirst = data.get(0).size();
//            int tempIndex = index;
//
//            tempIndex = tempIndex - sizeFirst;
//
//            // Starting point is layer 2
//
//            int layer = tempIndex / circularArrayCapacity + 1;
//            int internalIndex = tempIndex % circularArrayCapacity;
//
//
//            int lastIndex = data.size() - 1;
//            while (lastIndex < layer) { // Size() / circularArrayCapacity
//                CircularArray R = data.get(lastIndex);
//                CircularArray S = data.get(--lastIndex);
//
//                T e = S.popBack();
//                R.pushFront(e);
//
//                CircularArray cr = data.get(layer);
//                cr.insert(internalIndex, element); // circularArrayCapacity
//            }
//
//        }
//
//        private boolean ifSpaceAvailableInRight() {
//            CircularArray ca = data.get(data.size - 1);
//            return ca.size() < capacity();
//        }
//
//    }
//
///*
//CircularArraysDeque d {
//  data = [[0, 1], [2, 3, 4, X, 5, 6], [7, 8, 9, 10, 11], [12]]
//  circularArrayCapacity = 5
//}
//d.insert(5, X);
//*/
}

