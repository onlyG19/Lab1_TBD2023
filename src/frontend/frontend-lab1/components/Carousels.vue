<template>
  <!--  Carousel del Login  -->
  <v-carousel cycle>
    <v-carousel-item
      v-for="(img,i) in imgs"
      :key="i"
      :src="img.src"
      transition="fade-transition"
    ></v-carousel-item>
  </v-carousel>
</template>


<script>
  export default {
    props: {
      imgs: {
        required: true,
      }
    },
  }
</script>
