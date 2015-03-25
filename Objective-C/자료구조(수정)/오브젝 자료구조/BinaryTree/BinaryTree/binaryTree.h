//
//  binaryTree.h
//  BinaryTree
//
//  Created by MSW on 2015. 3. 25..
//  Copyright (c) 2015년 MSW. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface binaryTree : NSObject

-(void)addToNode: (NSString *)str;
-(void)deleteToNode;
-(void)deleteToTree;
-(void)preOrder: (NSString *)str;
-(void)inOrder: (NSString *)str;
-(void)postOrder: (NSString *)str;
@end
