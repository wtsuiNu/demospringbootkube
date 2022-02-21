package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: message.proto")
public final class MessagingServiceGrpc {

  private MessagingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.MessagingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest,
      com.example.grpc.MessagingResponse> getMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "message",
      requestType = com.example.grpc.MessagingRequest.class,
      responseType = com.example.grpc.MessagingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest,
      com.example.grpc.MessagingResponse> getMessageMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest, com.example.grpc.MessagingResponse> getMessageMethod;
    if ((getMessageMethod = MessagingServiceGrpc.getMessageMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getMessageMethod = MessagingServiceGrpc.getMessageMethod) == null) {
          MessagingServiceGrpc.getMessageMethod = getMessageMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.MessagingRequest, com.example.grpc.MessagingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "message"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MessagingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MessagingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("message"))
              .build();
        }
      }
    }
    return getMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest,
      com.example.grpc.MessagingResponse> getMessageStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "messageStream",
      requestType = com.example.grpc.MessagingRequest.class,
      responseType = com.example.grpc.MessagingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest,
      com.example.grpc.MessagingResponse> getMessageStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.MessagingRequest, com.example.grpc.MessagingResponse> getMessageStreamMethod;
    if ((getMessageStreamMethod = MessagingServiceGrpc.getMessageStreamMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getMessageStreamMethod = MessagingServiceGrpc.getMessageStreamMethod) == null) {
          MessagingServiceGrpc.getMessageStreamMethod = getMessageStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.MessagingRequest, com.example.grpc.MessagingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "messageStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MessagingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MessagingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("messageStream"))
              .build();
        }
      }
    }
    return getMessageStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.HeartBeatRequest,
      com.example.grpc.HeartBeatResponse> getRecordStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recordStream",
      requestType = com.example.grpc.HeartBeatRequest.class,
      responseType = com.example.grpc.HeartBeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.HeartBeatRequest,
      com.example.grpc.HeartBeatResponse> getRecordStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.HeartBeatRequest, com.example.grpc.HeartBeatResponse> getRecordStreamMethod;
    if ((getRecordStreamMethod = MessagingServiceGrpc.getRecordStreamMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getRecordStreamMethod = MessagingServiceGrpc.getRecordStreamMethod) == null) {
          MessagingServiceGrpc.getRecordStreamMethod = getRecordStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.HeartBeatRequest, com.example.grpc.HeartBeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recordStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.HeartBeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.HeartBeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("recordStream"))
              .build();
        }
      }
    }
    return getRecordStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceStub>() {
        @java.lang.Override
        public MessagingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceStub(channel, callOptions);
        }
      };
    return MessagingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceBlockingStub>() {
        @java.lang.Override
        public MessagingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceBlockingStub(channel, callOptions);
        }
      };
    return MessagingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceFutureStub>() {
        @java.lang.Override
        public MessagingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceFutureStub(channel, callOptions);
        }
      };
    return MessagingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MessagingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void message(com.example.grpc.MessagingRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMessageMethod(), responseObserver);
    }

    /**
     */
    public void messageStream(com.example.grpc.MessagingRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMessageStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.HeartBeatRequest> recordStream(
        io.grpc.stub.StreamObserver<com.example.grpc.HeartBeatResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getRecordStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.MessagingRequest,
                com.example.grpc.MessagingResponse>(
                  this, METHODID_MESSAGE)))
          .addMethod(
            getMessageStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.example.grpc.MessagingRequest,
                com.example.grpc.MessagingResponse>(
                  this, METHODID_MESSAGE_STREAM)))
          .addMethod(
            getRecordStreamMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.example.grpc.HeartBeatRequest,
                com.example.grpc.HeartBeatResponse>(
                  this, METHODID_RECORD_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class MessagingServiceStub extends io.grpc.stub.AbstractAsyncStub<MessagingServiceStub> {
    private MessagingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceStub(channel, callOptions);
    }

    /**
     */
    public void message(com.example.grpc.MessagingRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void messageStream(com.example.grpc.MessagingRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMessageStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.HeartBeatRequest> recordStream(
        io.grpc.stub.StreamObserver<com.example.grpc.HeartBeatResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getRecordStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MessagingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessagingServiceBlockingStub> {
    private MessagingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.MessagingResponse message(com.example.grpc.MessagingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.MessagingResponse> messageStream(
        com.example.grpc.MessagingRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMessageStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessagingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MessagingServiceFutureStub> {
    private MessagingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.MessagingResponse> message(
        com.example.grpc.MessagingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MESSAGE = 0;
  private static final int METHODID_MESSAGE_STREAM = 1;
  private static final int METHODID_RECORD_STREAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessagingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessagingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MESSAGE:
          serviceImpl.message((com.example.grpc.MessagingRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse>) responseObserver);
          break;
        case METHODID_MESSAGE_STREAM:
          serviceImpl.messageStream((com.example.grpc.MessagingRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.MessagingResponse>) responseObserver);
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
        case METHODID_RECORD_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordStream(
              (io.grpc.stub.StreamObserver<com.example.grpc.HeartBeatResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Message.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessagingService");
    }
  }

  private static final class MessagingServiceFileDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier {
    MessagingServiceFileDescriptorSupplier() {}
  }

  private static final class MessagingServiceMethodDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessagingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingServiceFileDescriptorSupplier())
              .addMethod(getMessageMethod())
              .addMethod(getMessageStreamMethod())
              .addMethod(getRecordStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
