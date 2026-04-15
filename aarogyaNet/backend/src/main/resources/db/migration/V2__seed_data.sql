INSERT INTO health_centers VALUES
('hc-001','Muzaffarnagar District Hospital','DISTRICT',
'Civil Lines','Uttar Pradesh','Muzaffarnagar',
NULL,'251001','0131-2600123',NULL,
29.4727,77.7085,200,45,true,true,true,3,true,true),

('hc-002','PHC Budhana','PHC',
'Budhana Road','Uttar Pradesh','Muzaffarnagar',
'Budhana','251309','0131-2700456',NULL,
29.5123,77.4567,30,12,false,false,true,1,false,true),

('hc-003','AIIMS Delhi','AIIMS',
'Ansari Nagar','Delhi','South Delhi',
NULL,'110029','011-26588500',NULL,
28.5672,77.2100,2000,230,true,true,true,15,true,true);

INSERT INTO blood_inventory VALUES
('bi-001','hc-001','A+',15,NOW()),
('bi-002','hc-001','B+',8,NOW()),
('bi-003','hc-001','O+',20,NOW()),
('bi-004','hc-001','AB+',5,NOW()),
('bi-005','hc-001','A-',3,NOW()),
('bi-006','hc-001','B-',2,NOW()),
('bi-007','hc-002','A+',4,NOW()),
('bi-008','hc-002','O+',6,NOW()),
('bi-009','hc-003','A+',50,NOW()),
('bi-010','hc-003','B+',40,NOW()),
('bi-011','hc-003','O+',60,NOW()),
('bi-012','hc-003','AB-',8,NOW());

INSERT INTO health_schemes VALUES
('sch-001','Ayushman Bharat - PMJAY',
'आयुष्मान भारत',
'Health insurance of 5 lakh per year',
'BPL families, SECC data beneficiaries',
'5 lakh annual health cover',
'https://pmjay.gov.in',
'Aadhaar, ration card',NULL,true),

('sch-002','Janani Suraksha Yojana',
'जननी सुरक्षा योजना',
'Cash assistance for institutional delivery',
'Pregnant women BPL',
'1400 rural / 1000 urban cash incentive',
'https://nhm.gov.in',
'Aadhaar, pregnancy registration',NULL,true),

('sch-003','Mukhyamantri Jan Arogya UP',
'मुख्यमंत्री जन आरोग्य योजना',
'UP state health scheme',
'UP residents not in PMJAY',
'5 lakh health cover',
'https://sects.up.gov.in',
'Aadhaar, UP domicile',
'Uttar Pradesh',true);