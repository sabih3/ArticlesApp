package com.example.newsapp.presentation.main.favorites

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.ViewModelProviderFactory
import com.example.newsapp.BR
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentFavoritesBinding
import com.example.newsapp.domain.dto.db.Article
import com.example.newsapp.presentation.base.BaseFragment
import com.example.newsapp.presentation.base.NavigationCommand
import com.example.newsapp.presentation.main.MainActivity
import com.example.newsapp.presentation.main.article.ArticleDataItem
import com.example.newsapp.presentation.main.article.ArticleFragmentDirections
import javax.inject.Inject

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(),
    FavoritesItemViewModelListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var favoritesAdapter: FavoritesAdapter

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_favorites

    override val viewModel: FavoritesViewModel
        get() = ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

    override fun onItemClick(item: Article) {
        navigate(
            NavigationCommand.To(
                ArticleFragmentDirections.toArticleDetailsFragment(
                    ArticleDataItem(
                        item.id,
                        item.imageUrl,
                        item.title,
                        item.byline,
                        item.abstractX,
                        item.publishedDate,
                        item.url,
                        item.coverImageUrl
                    )
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesAdapter = FavoritesAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        if (activity != null) {
            (activity as MainActivity).setSupportActionBar(getViewDataBinding().toolbar)
            getViewDataBinding().toolbar.title = getString(R.string.favorites)
            (activity as MainActivity).supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }

        }
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().favoritesRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().favoritesRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().favoritesRecyclerView.adapter = favoritesAdapter
    }
}