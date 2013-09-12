from twisted.internet import protocol, reactor

class Echo(protocol.Protocol):
    def dataReceived(self, data):
        print data
        self.transport.write(data + "\n")

class EchoFactory(protocol.Factory):
    def buildProtocol(self, addr):
        return Echo()

reactor.listenTCP(9999, EchoFactory())
reactor.run()

# Set up serial connection to Arduino
# self.ser = serial.Serial('/dev/ttyACM0', 9600)
# self.ser.open()
# self.ser.write(self.data)
# self.ser.close()
