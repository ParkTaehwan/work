//
//  node.h
//  BinaryTree
//
//  Created by MSW on 2015. 3. 25..
//  Copyright (c) 2015년 MSW. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface node : NSObject

-(id)initWith: (NSInteger *)num;
-(void)addNode:(NSInteger *)num;
-(void)printNode:(node *)printnode;
@property NSInteger *num;
@property node *parent;
@property node *leftChild;
@property node *rightChild;

@end
