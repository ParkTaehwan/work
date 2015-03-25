//
//  binaryTree.m
//  BinaryTree
//
//  Created by MSW on 2015. 3. 25..
//  Copyright (c) 2015년 MSW. All rights reserved.
//

#import "binaryTree.h"
#import "node.h"

@interface binaryTree ()
@property node *topNode;
@end


@implementation binaryTree
-(id)init
{
    self = [super init];
    if (self) {
        self.topNode = nil;
        self.topNode.leftChild = nil;
        self.topNode.rightChild = nil;
    }
    return self;
}

-(void)addToNode: (NSString *)str;
{
    node *newNode = [[node alloc]initwith:str];
    newNode.leftChild = nil;
    newNode.rightChild = nil;
    
}

-(void)preOrder: (NSString *)str
{
    node *current = [[node alloc]initWith:str];
    if(!self.topNode)
    {
        self.topNode = current;
    }
    else
    {
        
    }
}

@end
