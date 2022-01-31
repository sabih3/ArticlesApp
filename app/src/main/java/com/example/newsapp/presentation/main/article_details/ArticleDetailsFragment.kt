package com.example.newsapp.presentation.main.article_details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.ViewModelProviderFactory
import com.example.newsapp.BR
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentArticleDetailsBinding
import com.example.newsapp.presentation.base.BaseFragment
import com.example.newsapp.presentation.main.MainActivity
import com.example.newsapp.presentation.main.article.ArticleDataItem
import com.example.newsapp.utils.AppConstants
import javax.inject.Inject

class ArticleDetailsFragment :
    BaseFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>() {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var articleDataItem: ArticleDataItem? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article_details

    override val viewModel: ArticleDetailsViewModel
        get() = ViewModelProvider(this, factory).get(ArticleDetailsViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            articleDataItem = arguments?.getParcelable(AppConstants.ARTICLE)
            if (articleDataItem != null) { // To check if article is favorite or not
                articleDataItem?.id?.let { viewModel.getFavoriteById(it) }
            }
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpToolbar()
        setArticle()
    }

    private fun setArticle() {
        if (articleDataItem != null) {
            getViewDataBinding().article = articleDataItem
        }
    }

    private fun setUpToolbar() {
        if (activity != null) {
            (activity as MainActivity).setSupportActionBar(getViewDataBinding().toolbar)
            val actionBar = (activity as MainActivity).supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            actionBar?.setDisplayShowTitleEnabled(false)
        }
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
    }
}