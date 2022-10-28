package com.gultendogan.rickandmorty.presentation.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.gultendogan.rickandmorty.R
import com.gultendogan.rickandmorty.databinding.CharacterFilterBottomSheetBinding
import com.gultendogan.rickandmorty.utils.Constants.GENDER_DEFAULT
import com.gultendogan.rickandmorty.utils.Constants.SPECIES_DEFAULT
import com.gultendogan.rickandmorty.utils.Constants.STATUS_DEFAULT
import com.gultendogan.rickandmorty.utils.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip


class CharacterFilterBottomSheet : BottomSheetDialogFragment() {
    private val binding by viewBinding(CharacterFilterBottomSheetBinding::inflate)
    private val viewModel : CharacterViewModel by viewModels()
    private var statusChip = STATUS_DEFAULT
    private var speciesChip = SPECIES_DEFAULT
    private var genderChip = GENDER_DEFAULT

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        binding.chipGroupStatus.setOnCheckedStateChangeListener {  group, checkedIds ->
            val chip = group.findViewById<Chip>(checkedIds[0])
            statusChip = chip.text.toString()
        }

        binding.chipGroupSpecies.setOnCheckedStateChangeListener { group, checkedIds ->
            val chip = group.findViewById<Chip>(checkedIds[0])
            speciesChip = chip.text.toString()
        }

        binding.chipGroupGender.setOnCheckedStateChangeListener { group, checkedIds ->
            val chip = group.findViewById<Chip>(checkedIds[0])
            genderChip = chip.text.toString()
        }



        binding.btnApply.setOnClickListener {

            Log.e("asd","$statusChip $speciesChip $genderChip")
        }
         */
    }

}