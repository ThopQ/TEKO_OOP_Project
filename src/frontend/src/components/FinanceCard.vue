<script setup lang="ts">
defineProps<{
  colSpan: {
    type: Boolean;
    default: false;
  };
}>();
</script>

<template>
  <div
    class="card bg-base-100 shadow-lg rounded-lg w-full"
    :class="{ 'col-span-full': colSpan }"
  >
    <div class="bg-neutral text-neutral-content rounded-lg m-3 px-5 py-3">
      <div class="flex items-center gap-2">
        <slot name="toolbar"></slot>

        <h2 class="card-title"><slot name="title"></slot></h2>
      </div>
    </div>
    <div class="card-body">
      <slot name="body"></slot>
    </div>
  </div>
</template>
