//
//  main.m
//  BinaryTree
//
//  Created by MSW on 2015. 3. 25..
//  Copyright (c) 2015년 MSW. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "node.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
        node *nodetest=[[node alloc]initWith:(NSInteger *)4];
        [nodetest addNode:(NSInteger *)6];
        [nodetest addNode:(NSInteger *)2];
        [nodetest addNode:(NSInteger *)7];
        [nodetest addNode:(NSInteger *)1];
        [nodetest addNode:(NSInteger *)0];
 
        [nodetest printNode:nodetest];

    }
    return 0;
}
