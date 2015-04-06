//
//  ClinetConnector.h
//  SocketClient
//

#import <Foundation/Foundation.h>
#import <CFNetwork/CFNetwork.h>

@protocol ClientIF

- (int) OnReceive:(NSString*) msg;
- (int) OnDisconnect;
- (int) OnConnected;
- (int) OnError:(NSError*) err;
@end

@interface ClinetConnector : NSObject {

	CFStringRef		host;
	int				port;
	NSStream*	instream;
	NSStream*	outstream;
	id*			rcvif;
}

-(void) OnOpened;
-(void) OnHasRead;
-(void) OnHasWrite;
-(void) OnError;
-(void) OnEOF;

@end

