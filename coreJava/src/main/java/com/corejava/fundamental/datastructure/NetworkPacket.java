package com.corejava.fundamental.datastructure;


public class NetworkPacket {
    // State (Fields)
    int packetId;
    String sourceAddress;
    String destinationAddress;
    byte[] payload;
    int retryCount;

    // Behavior (Methods)
    void incrementRetry() {
        retryCount++;
    }

    boolean isRetransmissionLimitReached(int maxRetries) {
        return retryCount >= maxRetries;
    }

    int getPayloadSize() {
        if (payload == null) {
            return 0;
        }
        return payload.length;
    }
}