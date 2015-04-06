//
//  SocketClientAppDelegate.m
//  SocketClient
//


#import "SocketClientAppDelegate.h"
//#import "CFNetwork/CFNetwork.h"
#import "ClinetConnector.h"
@implementation SocketClientAppDelegate

@synthesize window;
@synthesize sndMsg;
@synthesize rcvMsg;
@synthesize connBtn;

- (void)applicationDidFinishLaunching:(UIApplication *)application {    

    // Override point for customization after application launch
	conn = [[ClinetConnector alloc] initWithIF:self];
	[window makeKeyAndVisible];
}

- (void)dealloc {
	[sndMsg release];
	
	[rcvMsg release];
    [window release];
    [super dealloc];
}

- (IBAction) buttonConnect:(id)sender {
	
	[conn Connect:@"192.9.85.96" port:10024];	
}

- (IBAction) buttonSend:(id)sender { 
	NSString* snddata = sndMsg.text;
	NSLog(snddata);
	[conn Send:snddata];
}

- (IBAction) buttonDisconnect:(id)sender {

	[conn Disconnect];
}

- (int) OnReceive:(NSString*) msg {
	
	if(rcvMsg.text != nil) {
	NSLog(rcvMsg.text);
//	rcvMsg.text = msg;
	rcvMsg.text = [rcvMsg.text stringByAppendingString:msg];
	NSLog(msg);
	}
}
- (int) OnError:(NSError*) err {
	NSLog([err description]);
}

- (int) OnConnected {
	NSLog(@"Connected...");
	[connBtn setTitle:@"connected"  forState:UIControlStateNormal];
}
- (int) OnDisconnect {
	[connBtn setTitle:@"connect"  forState:UIControlStateNormal];
	NSLog(@"Disconnected....");
}

@end
