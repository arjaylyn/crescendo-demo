package com.arjay.demo.model;

import java.util.UUID;

public record UploadResponse(String message, UUID jobId) {}
