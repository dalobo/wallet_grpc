package dalobo.grpc.withdraw;

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
    comments = "Source: withdraw.proto")
public final class WithdrawGrpc {

  private WithdrawGrpc() {}

  public static final String SERVICE_NAME = "withdraw.Withdraw";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dalobo.grpc.withdraw.WithdrawRequest,
      dalobo.grpc.withdraw.WithdrawResponse> METHOD_WITHDRAW =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "withdraw.Withdraw", "withdraw"),
          io.grpc.protobuf.ProtoUtils.marshaller(dalobo.grpc.withdraw.WithdrawRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(dalobo.grpc.withdraw.WithdrawResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WithdrawStub newStub(io.grpc.Channel channel) {
    return new WithdrawStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WithdrawBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WithdrawBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static WithdrawFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WithdrawFutureStub(channel);
  }

  /**
   */
  public static abstract class WithdrawImplBase implements io.grpc.BindableService {

    /**
     */
    public void withdraw(dalobo.grpc.withdraw.WithdrawRequest request,
        io.grpc.stub.StreamObserver<dalobo.grpc.withdraw.WithdrawResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WITHDRAW, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_WITHDRAW,
            asyncUnaryCall(
              new MethodHandlers<
                dalobo.grpc.withdraw.WithdrawRequest,
                dalobo.grpc.withdraw.WithdrawResponse>(
                  this, METHODID_WITHDRAW)))
          .build();
    }
  }

  /**
   */
  public static final class WithdrawStub extends io.grpc.stub.AbstractStub<WithdrawStub> {
    private WithdrawStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawStub(channel, callOptions);
    }

    /**
     */
    public void withdraw(dalobo.grpc.withdraw.WithdrawRequest request,
        io.grpc.stub.StreamObserver<dalobo.grpc.withdraw.WithdrawResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WITHDRAW, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WithdrawBlockingStub extends io.grpc.stub.AbstractStub<WithdrawBlockingStub> {
    private WithdrawBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawBlockingStub(channel, callOptions);
    }

    /**
     */
    public dalobo.grpc.withdraw.WithdrawResponse withdraw(dalobo.grpc.withdraw.WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WITHDRAW, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WithdrawFutureStub extends io.grpc.stub.AbstractStub<WithdrawFutureStub> {
    private WithdrawFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dalobo.grpc.withdraw.WithdrawResponse> withdraw(
        dalobo.grpc.withdraw.WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WITHDRAW, getCallOptions()), request);
    }
  }

  private static final int METHODID_WITHDRAW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WithdrawImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WithdrawImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((dalobo.grpc.withdraw.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<dalobo.grpc.withdraw.WithdrawResponse>) responseObserver);
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

  private static final class WithdrawDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dalobo.grpc.withdraw.WithdrawProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WithdrawGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WithdrawDescriptorSupplier())
              .addMethod(METHOD_WITHDRAW)
              .build();
        }
      }
    }
    return result;
  }
}
