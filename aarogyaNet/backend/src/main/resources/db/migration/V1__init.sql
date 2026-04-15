CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL DEFAULT 'PATIENT',
    state VARCHAR(50),
    district VARCHAR(50),
    village VARCHAR(50),
    preferred_language VARCHAR(5) DEFAULT 'hi',
    profile_image_url TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE health_centers (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    type VARCHAR(30) NOT NULL,
    address TEXT,
    state VARCHAR(50) NOT NULL,
    district VARCHAR(50) NOT NULL,
    village VARCHAR(50),
    pincode VARCHAR(10),
    phone VARCHAR(15),
    email VARCHAR(100),
    latitude DECIMAL(10,8),
    longitude DECIMAL(11,8),
    total_beds INT DEFAULT 0,
    available_beds INT DEFAULT 0,
    has_icu BOOLEAN DEFAULT FALSE,
    has_blood_bank BOOLEAN DEFAULT FALSE,
    has_ambulance BOOLEAN DEFAULT FALSE,
    ambulance_count INT DEFAULT 0,
    is_24x7 BOOLEAN DEFAULT FALSE,
    verified BOOLEAN DEFAULT FALSE
);

CREATE TABLE doctors (
    id VARCHAR(36) PRIMARY KEY,
    user_id VARCHAR(36) UNIQUE NOT NULL REFERENCES users(id),
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    qualifications TEXT,
    experience_years INT,
    consultation_fee DECIMAL(10,2),
    is_available_for_telemedicine BOOLEAN DEFAULT TRUE,
    bio TEXT,
    languages_spoken VARCHAR(200),
    rating DECIMAL(3,2) DEFAULT 0.0,
    total_consultations INT DEFAULT 0
);

CREATE TABLE emergency_requests (
    id VARCHAR(36) PRIMARY KEY,
    caller_name VARCHAR(100),
    caller_phone VARCHAR(15) NOT NULL,
    emergency_type VARCHAR(50) NOT NULL,
    description TEXT,
    latitude DECIMAL(10,8),
    longitude DECIMAL(11,8),
    address TEXT,
    status VARCHAR(20) DEFAULT 'PENDING',
    nearest_hospital_id VARCHAR(36) REFERENCES health_centers(id),
    responder_id VARCHAR(36),
    response_time_minutes INT,
    created_at TIMESTAMP DEFAULT NOW(),
    resolved_at TIMESTAMP
);

CREATE TABLE appointments (
    id VARCHAR(36) PRIMARY KEY,
    patient_id VARCHAR(36) NOT NULL REFERENCES users(id),
    doctor_id VARCHAR(36) NOT NULL REFERENCES doctors(id),
    health_center_id VARCHAR(36) REFERENCES health_centers(id),
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(20) DEFAULT 'SCHEDULED',
    type VARCHAR(15) DEFAULT 'IN_PERSON',
    chief_complaint TEXT,
    diagnosis TEXT,
    prescription TEXT,
    consultation_fee DECIMAL(10,2),
    telemedicine_link VARCHAR(500),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE blood_inventory (
    id VARCHAR(36) PRIMARY KEY,
    health_center_id VARCHAR(36) NOT NULL REFERENCES health_centers(id),
    blood_group VARCHAR(5) NOT NULL,
    units_available INT DEFAULT 0,
    last_updated TIMESTAMP DEFAULT NOW(),
    UNIQUE(health_center_id, blood_group)
);

CREATE TABLE health_schemes (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_hindi VARCHAR(200),
    description TEXT,
    eligibility_criteria TEXT,
    benefits TEXT,
    applying_url VARCHAR(500),
    documents_required TEXT,
    state VARCHAR(50),
    is_active BOOLEAN DEFAULT TRUE
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_phone ON users(phone);
CREATE INDEX idx_hc_state ON health_centers(state);
CREATE INDEX idx_emergency_status ON emergency_requests(status);
CREATE INDEX idx_blood_group ON blood_inventory(blood_group);