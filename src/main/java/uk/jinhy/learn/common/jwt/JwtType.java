package uk.jinhy.learn.common.jwt;

public enum JwtType {
    ACCESS_TOKEN("ACCESS_TOKEN"),
    REFRESH_TOKEN("REFRESH_TOKEN");

    private final String label;

    JwtType(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}

