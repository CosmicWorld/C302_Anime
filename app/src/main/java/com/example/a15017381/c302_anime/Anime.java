package com.example.a15017381.c302_anime;

/**
 * Created by 15017381 on 29/5/2017.
 */

public class Anime {
        private int id;
        private String image;
        private String name;
        private String description;
        private String link;

        public int getId() {
            return id;
        }
        public void setId(int setId) {
            this.id = id;
        }
        public String getImage() {
            return image;
        }
        public void setImage(String image) {
            this.image = image;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getLink() {
            return link;
        }
        public void setLink(String link) {
            this.link = link;
        }

        @Override
        public String toString() {
            return "Anime [id=" + id + ", name=" + name
                    + ", description=" + description + ", link=" + link + ", image=" + image + "]";
        }
}
