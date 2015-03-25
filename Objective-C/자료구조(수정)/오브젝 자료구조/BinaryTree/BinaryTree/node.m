//
//  node.m
//  BinaryTree
//
//  Created by MSW on 2015. 3. 25..
//  Copyright (c) 2015년 MSW. All rights reserved.
//

#import "node.h"

@implementation node
-(id)initWith: (NSInteger *)num
{
    self = [super init];
    if(self)
    {
        self.num = num;
    }
    self.parent=nil;
    self.leftChild=nil;
    self.rightChild=nil;
    return self;
    
}

-(void)addNode:(NSInteger *)num{
    
    node *bufNode=self;
    //node *buf;
    while(1){
        
        if(bufNode.num>=num){//새로운 데이터가 현재 노드의 데이터 보다 작거나 같을경우
            if(bufNode.leftChild==nil){//자식의 노드에 데이터가 없을경우
                bufNode.leftChild=[[node alloc]initWith:num];//자식의 공간 할당
                bufNode.leftChild.parent=bufNode;//부모 노드 연결
                bufNode=bufNode.leftChild;
                break;
            }
            else//자식의 노드에 데이터가 이미 있을경우
                bufNode=bufNode.leftChild;
        }
        else{
            if(bufNode.rightChild==nil){
                bufNode.rightChild=[[node alloc]initWith:num];
                bufNode.rightChild.parent=bufNode;
                bufNode=bufNode.rightChild;
                break;
            }
            else
                bufNode=bufNode.rightChild;
            
        }
    }
    
}

-(void)printNode:(node *)printnode{//전위 순회 탐색 방식
    NSLog(@"%zd ",printnode.num);
    if(printnode.leftChild!=nil)
        [printnode printNode:printnode.leftChild];
    if(printnode.rightChild!=nil)
        [printnode printNode:printnode.rightChild];
}
@end