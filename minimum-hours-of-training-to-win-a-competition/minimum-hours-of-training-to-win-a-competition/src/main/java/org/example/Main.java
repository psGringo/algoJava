package org.example;


/**
 * https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/description/
 */
public class Main {
    public static void main(String[] args) {
        minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50});
    }

    /**
     * my solution, passed  all cases
     *
     * @param initialEnergy
     * @param initialExperience
     * @param energy
     * @param experience
     * @return
     */
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energyNeeded = initialEnergy;
        for (int energyValue : energy) {
            energyNeeded -= energyValue;
        }

        // 1 hour needed to train energy
        int energyTrainingHours = 0;
        if (energyNeeded <= 0) {
            energyTrainingHours = (Math.abs(energyNeeded) + 1) * 1;
        }

        int currentExperience = initialExperience;
        int experienceNeeded = 0;
        for (int experienceValue : experience) {

            if (currentExperience <= experienceValue) {
                // train
                int diff = experienceValue - currentExperience + 1;
                currentExperience += diff;
                experienceNeeded += diff;
            }

            currentExperience += experienceValue;
        }

        int experienceTrainingHours = experienceNeeded * 1;

        return experienceTrainingHours + energyTrainingHours;
    }
}