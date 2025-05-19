package exercicio04.enums;

public enum UsuarioStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String description;

    UsuarioStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
