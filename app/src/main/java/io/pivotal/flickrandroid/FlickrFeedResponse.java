package io.pivotal.flickrandroid;

import java.util.List;

public class FlickrFeedResponse {
    private List<FlickrFeedResponseItem> items;

    public void setItems(List<FlickrFeedResponseItem> items) {
        this.items = items;
    }

    public List<FlickrFeedResponseItem> getItems() {
        return items;
    }

    public static class FlickrFeedResponseItem {
        private Media media;
        private String title;

        public void setMedia(Media media) {
            this.media = media;
        }

        public Media getMedia() {
            return media;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public static class Media {
            private String m;

            public Media(String m) {
                this.m = m;
            }

            public String getM() {
                return m;
            }

            public void setM(String m) {
                this.m = m;
            }
        }
    }
}
