package com.prince.util;


/**
 * @description: 雪花算法
 *
 * @author Prince
 * @time 2020/8/25 9:18
 */
public class SnowFlakeGenerator {
    private long roomId;
    private long workerId;
    private long roomIdBit = 5L;
    private long workerIdBit = 5L;
    private long maxRoomId;
    private long maxWorkerId;
    private long sequenceBits;
    private long sequence;
    private long sequenceMask;
    private long lastTimeStamp;
    private long twepoch;
    private long wokerIdShift;
    private long roomIdShift;
    private long timeStampShift;

    public SnowFlakeGenerator(long roomId, long wokerId, long sequence) {
        this.maxRoomId = ~(-1L << (int)this.roomIdBit);
        this.maxWorkerId = ~(-1L << (int)this.workerIdBit);
        this.sequenceBits = 12L;
        this.sequenceMask = ~(-1L << (int)this.sequenceBits);
        this.lastTimeStamp = -1L;
        this.twepoch = 1597998450456L;
        this.wokerIdShift = this.sequenceBits;
        this.roomIdShift = this.sequenceBits + this.workerIdBit;
        this.timeStampShift = this.sequenceBits + this.workerIdBit + this.roomIdBit;
        if (wokerId <= this.maxWorkerId && wokerId >= 0L) {
            if (roomId <= this.maxRoomId && roomId >= 0L) {
                this.roomId = roomId;
                this.workerId = wokerId;
                this.sequence = sequence;
            } else {
                throw new IllegalArgumentException("room Id 错误");
            }
        } else {
            throw new IllegalArgumentException("woker Id 错误");
        }
    }

    public synchronized long nextVal() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < this.lastTimeStamp) {
            throw new RuntimeException("时间戳异常");
        } else {
            if (this.lastTimeStamp == timestamp) {
                this.sequence = this.sequence + 1L & this.sequenceMask;
                if (this.sequence == 0L) {
                    timestamp = this.waitToNextMills(this.lastTimeStamp);
                }
            } else {
                this.sequence = timestamp & 1L;
            }

            this.lastTimeStamp = timestamp;
            return timestamp - this.twepoch << (int)this.timeStampShift | this.roomId << (int)this.roomIdShift | this.workerId << (int)this.wokerIdShift | this.sequence;
        }
    }

    private long waitToNextMills(long lastTimeStamp) {
        long timestamp;
        for(timestamp = System.currentTimeMillis(); timestamp <= lastTimeStamp; timestamp = System.currentTimeMillis()) {
        }

        return timestamp;
    }

    public static void main(String[] args) {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator(1L, 1L, 0);
        for (int i = 0; i < 10; i++) {
            System.out.println(snowFlakeGenerator.nextVal());
        }
    }
}
