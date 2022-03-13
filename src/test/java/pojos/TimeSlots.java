package pojos;

public class TimeSlots {
        private String datefrom;
        private String dateto;
        private String ID;
        private String StartDateTime;
        private String EndDateTime;
        private String Status ;
        private String Anamnesis;
        private String Treatment;
        private String Diagnosis;
        private String Prescription;
        private String Description;
        private String CreatedDate;
        private String Physician;
        private String Patient;

        public TimeSlots() {
        }

        public TimeSlots(String datefrom, String dateto, String ID, String startDateTime, String endDateTime, String status, String anamnesis, String treatment, String diagnosis, String prescription, String description, String createdDate, String physician, String patient) {
                this.datefrom = datefrom;
                this.dateto = dateto;
                this.ID = ID;
                this.StartDateTime = startDateTime;
                this.EndDateTime = endDateTime;
                this.Status = status;
                this.Anamnesis = anamnesis;
                this.Treatment = treatment;
                this.Diagnosis = diagnosis;
                this.Prescription = prescription;
                this.Description = description;
                this.CreatedDate = createdDate;
                this.Physician = physician;
                this.Patient = patient;
        }

        public String getDatefrom() {
                return datefrom;
        }

        public void setDatefrom(String datefrom) {
                this.datefrom = datefrom;
        }

        public String getDateto() {
                return dateto;
        }

        public void setDateto(String dateto) {
                this.dateto = dateto;
        }

        public String getID() {
                return ID;
        }

        public void setID(String ID) {
                this.ID = ID;
        }

        public String getStartDateTime() {
                return StartDateTime;
        }

        public void setStartDateTime(String startDateTime) {
                StartDateTime = startDateTime;
        }

        public String getEndDateTime() {
                return EndDateTime;
        }

        public void setEndDateTime(String endDateTime) {
                EndDateTime = endDateTime;
        }

        public String getStatus() {
                return Status;
        }

        public void setStatus(String status) {
                Status = status;
        }

        public String getAnamnesis() {
                return Anamnesis;
        }

        public void setAnamnesis(String anamnesis) {
                Anamnesis = anamnesis;
        }

        public String getTreatment() {
                return Treatment;
        }

        public void setTreatment(String treatment) {
                Treatment = treatment;
        }

        public String getDiagnosis() {
                return Diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
                Diagnosis = diagnosis;
        }

        public String getPrescription() {
                return Prescription;
        }

        public void setPrescription(String prescription) {
                Prescription = prescription;
        }

        public String getDescription() {
                return Description;
        }

        public void setDescription(String description) {
                Description = description;
        }

        public String getCreatedDate() {
                return CreatedDate;
        }

        public void setCreatedDate(String createdDate) {
                CreatedDate = createdDate;
        }

        public String getPhysician() {
                return Physician;
        }

        public void setPhysician(String physician) {
                Physician = physician;
        }

        public String getPatient() {
                return Patient;
        }

        public void setPatient(String patient) {
                Patient = patient;
        }

        @Override
        public String toString() {
                return "TimeSlots{" +
                        "datefrom='" + datefrom + '\'' +
                        ", dateto='" + dateto + '\'' +
                        ", ID='" + ID + '\'' +
                        ", StartDateTime='" + StartDateTime + '\'' +
                        ", EndDateTime='" + EndDateTime + '\'' +
                        ", Status='" + Status + '\'' +
                        ", Anamnesis='" + Anamnesis + '\'' +
                        ", Treatment='" + Treatment + '\'' +
                        ", Diagnosis='" + Diagnosis + '\'' +
                        ", Prescription='" + Prescription + '\'' +
                        ", Description='" + Description + '\'' +
                        ", CreatedDate='" + CreatedDate + '\'' +
                        ", Physician='" + Physician + '\'' +
                        ", Patient='" + Patient + '\'' +
                        '}';
        }
}

