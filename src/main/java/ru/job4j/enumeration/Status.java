package ru.job4j.enumeration;

public enum Status {
    ACCEPTED("Accepted") {
        private String message = "Auto accepted";

        @Override
        public String getMessage() {
            return message;
        }

    },
    IN_WORK("In work") {
        private String message = "Auto in work";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING("Waiting") {
        private String message = "Auto waiting";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED("Finished") {
        private String message = "Work is finished";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public abstract String getMessage();

}