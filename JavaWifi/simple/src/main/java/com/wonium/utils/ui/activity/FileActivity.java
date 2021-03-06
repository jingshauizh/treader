/*
 * Copyright  2018.  wonium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.wonium.utils.ui.activity;

import android.databinding.DataBindingUtil;

import com.wonium.example.R;
import com.wonium.example.databinding.ActivityFileBinding;
import com.wonium.extension.utils.FileUtil;

public class FileActivity extends BaseActivity {

    private ActivityFileBinding mBinding;
    @Override
    public void initView(int layoutResID) {
        mBinding=DataBindingUtil.setContentView(this,layoutResID);
    }

    @Override
    public void initListener() {
        mBinding.btnReadFile.setOnClickListener(v -> mBinding.tvFileResult.setText(FileUtil.INSTANCE.readAssetsFile(this,"Item001.zhd")));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_file;
    }
}
