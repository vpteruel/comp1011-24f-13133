package com.vinicius.rickandmorty.enums;

public enum View {
    CHARACTER() {
        @Override public String getPath() { return "views/character.fxml"; }
        @Override public String getTitle() { return "Character"; }
    },
    DASHBOARD() {
        @Override public String getPath() { return "views/dashboard.fxml"; }
        @Override public String getTitle() { return "Dashboard"; }
    },
    EPISODE() {
        @Override public String getPath() { return "views/episode.fxml"; }
        @Override public String getTitle() { return "Episode"; }
    },
    MAIN() {
        @Override public String getPath() { return "views/main.fxml"; }
        @Override public String getTitle() { return "Main"; }
    },
    SEARCHER() {
        @Override public String getPath() { return "views/searcher.fxml"; }
        @Override public String getTitle() { return "Searcher"; }
    },
    SKELETON_LOADING() {
        @Override public String getPath() { return "views/skeleton-loading.fxml"; }
        @Override public String getTitle() { return "Skeleton Loading"; }
    };

    public abstract String getPath();
    public abstract String getTitle();
}
