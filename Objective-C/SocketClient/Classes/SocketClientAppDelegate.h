//
//  SocketClientAppDelegate.h
//  SocketClient
//

#import <UIKit/UIKit.h>
#import "ClinetConnector.h"

@interface SocketClientAppDelegate : NSObject <UIApplicationDelegate, ClientIF> {
	
    UIWindow *window;
	UITextField *rcvMsg;
	UITextField *sndMsg;
	ClinetConnector *conn;
	UIButton *connBtn;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet UITextField* rcvMsg;
@property (nonatomic, retain) IBOutlet UITextField* sndMsg;
@property (nonatomic, retain) ClinetConnector *conn;
@property IBOutlet UIButton *connBtn;

- (IBAction) buttonConnect:(id)sender;
- (IBAction) buttonSend:(id)sender;
- (IBAction) buttonDisconnect:(id)sender;

@end

