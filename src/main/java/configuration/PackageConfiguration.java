package configuration;

public abstract class PackageConfiguration {
    public static final String[] PACKAGE_TYPES = {"Mala", "Container", "Caixa"};
    public static final String[] PACKAGE_CATEGORIES = {"Normal", "Refrigerado", "Frágil", "Vivo"};
    public static final String[] PACKAGE_WEIGTH_FORMATES = {"KG", "LBS", "g"};
    public static final String[] PACKAGE_HISTORY_ACTIONS = {
            "Pacote Redirecionado",
            "Pacote Embarcado",
            "Pacote Inspecionado",
            "Pacote em Voo",
            "Pacote no Destino",
            "Pacote Entregue",
            "Pacote Danificado",
            "Pacote Roubado",
            "Pacote Perdido",
            "Pacote Confiscado",
    };
}
