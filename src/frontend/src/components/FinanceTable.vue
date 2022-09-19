<script setup lang="ts">
import { ref } from "vue";
import Entry from "../models/Entry";

const emit = defineEmits(["addEntry", "removeEntry"]);

defineProps<{
  entries: Entry[];
}>();

const newEntry = ref({
  description: "",
  amount: "",
});

function addEntry() {
  emit("addEntry", newEntry.value);
  newEntry.value = {
    description: "",
    amount: "",
  };
}
</script>

<template>
  <form @submit.prevent="addEntry">
    <div class="shadow rounded-lg overflow-x-auto">
      <table class="table w-full">
        <thead>
          <tr>
            <th>
              <input
                v-model="newEntry.description"
                type="text"
                placeholder="Description"
                class="input input-sm w-full max-w-xs"
                required
              />
            </th>
            <th>
              <input
                v-model="newEntry.amount"
                type="number"
                placeholder="CHF 0.-"
                class="input input-sm w-24"
                step=".01"
                required
              />
            </th>
            <th>
              <button class="btn btn-sm btn-outline" type="submit">Add</button>
            </th>
          </tr>
        </thead>
        <tbody v-if="entries.length">
          <tr v-for="(entry, index) in entries" :key="index">
            <td>{{ entry.description }}</td>
            <td>{{ entry.amount.toFixed(2) }}</td>
            <td>
              <button
                class="btn btn-sm btn-secondary btn-outline"
                type="button"
                @click="$emit('removeEntry', entry)"
              >
                X
              </button>
            </td>
          </tr>
        </tbody>
        <tbody v-else>
          <tr>
            <td>No Entries</td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</template>

<style scoped>
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type="number"] {
  -moz-appearance: textfield;
}
</style>
