/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalsystemclass;

    private Iterable<Patient> patients;
    private Iterable<HospitalBed> beds;
    private Object patient;

    private boolean patients() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int patient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
/**
 *
 * @author Student
 */
public class HospitalSystem {
        
        private ArrayList<Patient> patients;
        private HospitalBed[] beds;
        private int i = 0;
        
        public HospitalSystem(){
            patients = new ArrayList<>();
            beds = new HospitalBed[20];
            
            
            
         // Create 20 hospital beds: B01 - B20
            
        for (int i = 0;i< 20;i++){
            String bedNumber = String.format("B%02d", i + 1);
            beds[i] = new HospitalBed(bedNumber);
            
        }
    }   
    }

// FEATURE 1
// Register a new patient

public boolean registerPatient(Patient patient){
    
    if (searchPatient(patient.getPatientId())!=null){
    return false;
}
        patient = patient;
        patient = patient;
        patient.add(patient);
        return true;
    
    
}

// Search for a patient
    public Patient searchPatient(String patientId) {
   
        
        for (Patient patient : patients){
            
            if (patient.getPatientId().equalsIgnoreCase(patientId)){
                return patient;
            }
        }
        
        return null;
    }
    
    // Update patient details
    
    public boolean updatePatient(String patientId, String firstName, String lastName, int age, String gender, String medicalCondition){
        Patient patient = searchPatient(patientId);
        
        if (patient == null){
            return false;
        }
        
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setMedicalCondition(medicalCondition);
        
        return true;
    }

// Delete patient

public boolean deletePatient(String patientId){
    
    Patient patient = searchPatient(patientId);
    
    if (patient == null){
        return false;
    }
    
    patient.remove(patient);
    return true;
}

// Display all registered patients

public void displayAllPatients(){
    
    if(patients()){
        System.out.println("No patients registered.");
        return;
    }
    for (Patient patient : patients){
        
        patient.displayDetails();
        
        System.out.println("------------------");
    }
}

// FEATURE 2
// Allocate a bed

public boolean allocateBed(String bedNumber, String patientId, Iterable<HospitalBed> beds){
    
    Patient patient = searchPatient(patientId);
    
    if (patient == null){
        return false;
    
    }
    
    for (HospitalBed bed : beds){
        
        if (bed.getBedNumber().equalsIgnoreCase(bedNumber)){
            
            if (bed.isOccupied()){
                return false;
            }
            
            bed.allocateBed(patientId);
            return true;
        }
    }
    
    return false;
}

// Release a bed

public boolean releaseBed(String bedNumber){
    
    for (HospitalBed bed : beds){
        
         if (bed.getBedNumber().equalsIgnoreCase(bedNumber)){
            
            if (!bed.isOccupied()){
                return false;
            }
            
            bed.releaseBed();
            return true;
        }
    }
    
    return false;
}

// Display available beds

public void displayAvailableBeds(){
    
    System.out.println("Available Beds");
    
    for (HospitalBed bed : beds){
        
        if (!bed.isOccupied()){
            System.out.println(bed.getBedNumber());
        }
    }
}

// Display occupied beds

public void displayOccupiedBeds(){
    
    System.out.println("Occupied Beds:");
    
    for (HospitalBed bed : beds){
        
        if(bed.isOccupied()){
            System.out.println(bed.getBedNumber() + "-Patient ID:" + bed.getPatientId);
        }
    }
}

// FEATURE 3
// Number of registered patients

public int getTotalPatients(){
    return patient();
}

// Number of occupied beds

public int getOccupiedBeds(){
    
    int count = 0;
    
    for (HospitalBed bed : beds){
        
        if (bed.isOccupied()){
            count++;
        }
    }
    
    return count;
}

// Number of available beds

public int getAvailableBeds(){
   return 20 - getOccupiedBeds();
}

// Ward occupancy percentage 

public double getOccupancyPercentage(){
    return (getOccupiedBeds()/ 20.0)*100;
}
