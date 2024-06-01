package org.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class PartitioningUtil {

    /* Copyright goes to ChatGPT */
    public static int assignPartitionNumber(int numPartitions) {
        try {
            // Step 1: Generate a UUID
            UUID randomUUID = UUID.randomUUID();
            String uuidStr = randomUUID.toString();

            // Step 2: Hash the UUID using SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(uuidStr.getBytes());

            // Step 3: Convert the hash to an integer
            int hashInt = 0;
            for (int i = 0; i < 4; i++) {
                hashInt = (hashInt << 8) | (hashBytes[i] & 0xFF);
            }

            // Step 4: Use modulo operation to get the partition number
            int partitionNumber = Math.abs(hashInt) % numPartitions;

            return partitionNumber;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
