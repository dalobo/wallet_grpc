package dalobo.grpc.balance;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: balance.proto")
public final class BalanceGrpc {

  private BalanceGrpc() {}

  public static final String SERVICE_NAME = "balance.Balance";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dalobo.grpc.balance.BalanceRequest,
      dalobo.grpc.balance.BalanceResponse> METHOD_GET_BALANCE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "balance.Balance", "getBalance"),
          io.grpc.protobuf.ProtoUtils.marshaller(dalobo.grpc.balance.BalanceRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(dalobo.grpc.balance.BalanceResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BalanceStub newStub(io.grpc.Channel channel) {
    return new BalanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BalanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BalanceFutureStub(channel);
  }

  /**
   */
  public static abstract class BalanceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBalance(dalobo.grpc.balance.BalanceRequest request,
        io.grpc.stub.StreamObserver<dalobo.grpc.balance.BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BALANCE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_BALANCE,
            asyncUnaryCall(
              new MethodHandlers<
                dalobo.grpc.balance.BalanceRequest,
                dalobo.grpc.balance.BalanceResponse>(
                  this, METHODID_GET_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class BalanceStub extends io.grpc.stub.AbstractStub<BalanceStub> {
    private BalanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceStub(channel, callOptions);
    }

    /**
     */
    public void getBalance(dalobo.grpc.balance.BalanceRequest request,
        io.grpc.stub.StreamObserver<dalobo.grpc.balance.BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BALANCE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BalanceBlockingStub extends io.grpc.stub.AbstractStub<BalanceBlockingStub> {
    private BalanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dalobo.grpc.balance.BalanceResponse getBalance(dalobo.grpc.balance.BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BALANCE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BalanceFutureStub extends io.grpc.stub.AbstractStub<BalanceFutureStub> {
    private BalanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dalobo.grpc.balance.BalanceResponse> getBalance(
        dalobo.grpc.balance.BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BALANCE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BALANCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BalanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BalanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((dalobo.grpc.balance.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<dalobo.grpc.balance.BalanceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BalanceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dalobo.grpc.balance.BalanceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BalanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BalanceDescriptorSupplier())
              .addMethod(METHOD_GET_BALANCE)
              .build();
        }
      }
    }
    return result;
  }
}
