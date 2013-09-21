from twisted.internet import protocol, reactor
#import serial

class Echo(protocol.Protocol):
    def dataReceived(self, data):
        print data
        #ser.write(data)
        #ser.flush()
        self.transport.write(data + "\n")

class EchoFactory(protocol.Factory):
    def buildProtocol(self, addr):
        return Echo()

if __name__ == '__main__':
    #ser = serial.Serial('/dev/ttyACM0', 9600)
    #ser.open()
    reactor.listenTCP(9999, EchoFactory())
    reactor.run()
    #self.ser.close()
